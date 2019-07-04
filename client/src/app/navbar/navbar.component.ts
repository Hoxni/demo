import { Component } from '@angular/core';
import { Router } from '@angular/router';

import User from '../_models/user';
import { AuthenticationService } from '../_sevices/authentication.service';
import { ProductsGuard } from '../_guards/products.guard';
import { CatalogGuard } from '../_guards/catalog.guard';
import { OrdersGuard } from '../_guards/orders.guard';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent {
  user: User;

  constructor(private router: Router,
              private authenticationService: AuthenticationService) {
    authenticationService.currentUser().subscribe(user => this.user = user);
  }

  canSeeProducts() {
    return ProductsGuard.check(this.user);
  }

  canSeeCatalog(){
    return CatalogGuard.check(this.user);
  }

  canSeeOrders(){
    return OrdersGuard.check(this.user);
  }

  logout() {
    this.authenticationService.logout().subscribe(
      () => this.router.navigate(['login']),
      err => console.error(err));
  }
}
