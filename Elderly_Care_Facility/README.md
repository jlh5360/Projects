# U-Fund:  Elderly Care Facility

An online U-Fund system built in Java 17 using the Spring API framework for the backend and Angular for the frontend website.

## Team

- Andrew Zou
- Michael Brenner
- Jonathan Ho
- Renzhong Huang

## Prerequisites

- Java 11=>17 (Make sure to have the correct JAVA_HOME setup in your environment)
- Maven
- Node.js 20.6.1 or higher
- Npm 9.8.1 or higher

## How to run it

1. Clone the repository and go to the root directory.
2. Start API backend server
    1. Execute `mvn compile exec:java`in the ufund-api directory in the terminal
3. Start frontend server
    1. Run `npm install` from inside the ufund-ui direcotry
    2. Run `npm install -g @angular/cli` to install the Angular cli tool
    3. Run `ng start --open` to start the frontend server and access the website

## Known bugs and disclaimers

(It may be the case that your implementation is not perfect.)

Document any known bug or nuisance.
If any shortcomings, make clear what these are and where they are located.

- Currently you are unable to see a list of elderly you have adopted from the profile page
- When you click adopt on elderly in the adopt elderly page, there is no persistence
- Because of there being no persistence in the adopt elderly page, there is no way to tell who has been adopted by a specific user

## How to test it

The Maven build script provides hooks for run unit tests and generate code coverage
reports in HTML.

To run tests on all tiers together do this:

1. Execute `mvn clean test jacoco:report`
2. Open in your browser the file at `PROJECT_API_HOME/target/site/jacoco/index.html`

To run tests on a single tier do this:

1. Execute `mvn clean test-compile surefire:test@tier jacoco:report@tier` where `tier` is one of `controller`, `model`, `persistence`
2. Open in your browser the file at `PROJECT_API_HOME/target/site/jacoco/{controller, model, persistence}/index.html`

To run tests on all the tiers in isolation do this:

1. Execute `mvn exec:exec@tests-and-coverage`
2. To view the Controller tier tests open in your browser the file at `PROJECT_API_HOME/target/site/jacoco/model/index.html`
3. To view the Model tier tests open in your browser the file at `PROJECT_API_HOME/target/site/jacoco/model/index.html`
4. To view the Persistence tier tests open in your browser the file at `PROJECT_API_HOME/target/site/jacoco/model/index.html`

*(Consider using `mvn clean verify` to attest you have reached the target threshold for coverage)

## How to generate the Design documentation PDF

1. Access the `PROJECT_DOCS_HOME/` directory
2. Execute `mvn exec:exec@docs`
3. The generated PDF will be in `PROJECT_DOCS_HOME/` directory

## How to setup/run/test program

1. Tester, first obtain the Acceptance Test plan.
2. IP address of target machine running the app.
3. Execute commands found in the How to Run section above.
4. Access via ip address of computer hosting to see website.
    - When you make changes to the frontend code you will see your changes reflected here.
5. If you make changes to the API you must restart the backend server each time to see changes take effect.

## License

MIT License

See LICENSE for details.





