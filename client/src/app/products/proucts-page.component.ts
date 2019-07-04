/**
 * Created by Drapegnik on 5/29/17.
 */

import { Component } from '@angular/core';

import User from '../_models/user';
import Product from '../_models/product';
import { ProductsService } from '../_sevices/products.service';
import { AuthenticationService } from '../_sevices/authentication.service';
import { CatalogGuard } from 'app/_guards/catalog.guard';
import { ProductsGuard } from 'app/_guards/products.guard';


@Component({
  selector: 'app-orders-page',
  template: `
    <app-products-table [products]="products"></app-products-table>
    <app-circle-btn
    *ngIf="canEdit()"
    [link]="'edit'"
    [iconClass]="'glyphicon glyphicon-edit'"
  ></app-circle-btn>
  `
})
export class ProductsPageComponent {
  products: Array<Product>;
  user: User;

  constructor(private productsService: ProductsService, private authenticationService: AuthenticationService) {
    productsService.getAll().subscribe(products => this.products = products);
    authenticationService.currentUser().subscribe(user => this.user = user);
  }

  canEdit(){
    return ProductsGuard.checkEdit(this.user);
  }

}
