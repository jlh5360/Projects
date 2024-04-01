import { Component } from '@angular/core';
import {User} from '../user';
import {AuthService} from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  isLoggedIn: boolean = false;
  currentUser: User = {} as User;

  constructor(private authService: AuthService) {}

  // model to reset back to after submission
  masterModel: User = {"name": "", "password": ""} as User;
  // model that is being changed by the form
  userModel: User = {"name": "", "password": ""} as User;

  ngOnInit(): void {
    var currentUser = localStorage.getItem("currentUser");
    if (currentUser == null) {
      this.isLoggedIn = false;
    } else {
      this.isLoggedIn = true;
      this.currentUser = JSON.parse(currentUser);
    }
  }

  // run when login button is run
  onLogin() {
    this.authService.login(this.userModel)
    .subscribe(user => {
      if (user == undefined) {
        return;
      }
      this.authService.setCurrentUser(user);
      location.pathname = ('/homepage');
    });

  }

  onSignup() {
    this.authService.signup(this.userModel)
    .subscribe(user => {
      if (user == undefined) {
        return;
      }
      this.authService.setCurrentUser(user);
      location.pathname = ('/homepage');
    });
  }

  // run after onSubmit is run
  onReset() {
    this.userModel = structuredClone(this.masterModel);
  }

  logout() {
    console.log(this.currentUser);
    this.authService.logout(this.currentUser)
      .subscribe(_user => {
        localStorage.removeItem("currentUser");
        location.pathname = ('/login');
      });
  }

}
