import { Component } from '@angular/core';
import {User} from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styles: [`
  body, html {
    margin: 0;
    padding: 0;
  }
  .navbar {
    display: flex;
    width: 100%;
    background-color: rgba(39, 112, 230);
    padding: 20px 0;
    margin-bottom: 20px;
    align-items: center;
    justify-content: center;
  }
  .navbar a {
    padding: 5px 10px;
    text-decoration: none;
    margin-right: 20px;
    color: white;
    font-family: "Lato", sans-serif;
    font-weight: bold;
  }
  .navbar a.current {
    text-decoration: underline;
  }
  .navbar a:hover {
    background-color: rgba(255, 255, 255, 0.5);
  }
  .right {
    position: absolute;
    right: 10vw;
  }
  .rightmore {
    position: absolute;
    right: 2vw;
  }
  .left {
    position: absolute;
    left: 2vw;
  }

  `]
})
export class AppComponent {

  isLoggedIn: boolean = false;
  isAdmin: boolean = false;
  loginLabel: string = "Sign in";

  // constructor(private authService: AuthService) {}

  ngOnInit(): void {
    var currentUser = localStorage.getItem("currentUser");
    var user: User = {} as User;
    if (currentUser == null) {
      this.isLoggedIn = false;
    } else {
      this.isLoggedIn = true;
      user = JSON.parse(currentUser);
      this.isAdmin = user.admin;
      console.log(user);
      this.loginLabel = this.isLoggedIn ? "Profile" : "Sign in";
    }
  }
}
