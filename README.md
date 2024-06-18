# Supplier Api

## Class Diagram

```mermaid
classDiagram
    class Company {
        -String name
        -String number
        -String zipCode
        -Branch branch
        -Service[] services
        -Product[] products
    }

    class BaseTemplate {
        -Long id
        -String description
    }

    class Service {
    }

    class Product {
    }

    class Branch {
    }

    Service o-- BaseTemplate
    Product o-- BaseTemplate
    Branch o-- BaseTemplate
    Company o-- Service
    Company o-- Product
    Company o-- Branch
```
