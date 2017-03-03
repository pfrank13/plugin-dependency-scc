An initial build of this project from the root with a simple
```bash
./mvnw clean install
```
will show that the extending_dsl project artifact is trying to be resolved before it is initially built.  It is required in the consuming project using_extended_dsl in the build plugin for Spring Cloud Contract (which I believe has nothing to do with the issue)
