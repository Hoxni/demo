/**
 * Created by Drapegnik on 5/29/17.
 */

import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { ProductsService } from '../_sevices/products.service';
import Catalog from '../_models/catalog';
import Product from 'app/_models/product';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-orders-page',
  templateUrl: './product-form.component.html'
})
export class ProductEditComponent {
  products: Array<Product>;
  result: Array<Product>;
  form: FormGroup;
  isEditing: boolean;
  buttonText: string;

  constructor(private productsService: ProductsService, private router: Router, private fb: FormBuilder, ) {

    productsService.getAll().subscribe(products => this.products = products);

    this.isEditing = true;
    this.buttonText = 'Confirm';

    this.form = fb.group({
      _id: ['', Validators.required],
      title: [''],
      type: [''],
      price: [''],
    })

    this.create = this.create.bind(this);
  }

  checkId(){
    const _id = this.form.controls['_id'].value;
    return this.products.some(p => p.id === _id);
  }

  create() {
    const id = this.form.controls['_id'].value;
    const title = this.form.controls['title'].value;
    const type = this.form.controls['type'].value;
    const price = this.form.controls['price'].value;

    if(!this.checkId()){
      this.products.push(new Product({ id, title, type, price }));// = this.products.push()
    }

    // this.productsService.create(new Product({ id, title, type, price })).subscribe(
    //   () => {
    //     this.router.navigate(['products/edit']);
    //   },
    //   (err) => {
    //     console.error(`Error: ${err._body}`);
    //   });
    //update table after create(); add in table then in base
  }

  selectProduct(p: Product) {
    p.selected = !p.selected;
  }

  save() {
    if (!this.isEditing) {
      this.result.forEach(p => {
        if (!p.selected) {
          this.productsService.create(new Product(p)).subscribe(
            () => {
              this.router.navigate(['products']);
            },
            (err) => {
              console.error(`Error: ${err._body}`);
            });
        } else {
          this.productsService.delete(p.id).subscribe(
            () => {
              this.router.navigate(['products']);
            },
            (err) => {
              console.error(`Error: ${err._body}`);
            });
        }
      });
    } else {
      this.isEditing = false;
      this.result = this.products;
      this.products = this.products.filter(p => !p.selected);
      this.buttonText = 'Save'
    }
  }

  cancel(){
    if(!this.isEditing){
      this.isEditing = true;
      this.buttonText = 'Confirm'
      this.products = this.result;
    } else {
      this.router.navigate(['products']);
    }
  }
}