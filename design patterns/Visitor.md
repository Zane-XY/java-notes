Visitor
======
one day you suddenly want to move your domain specific logics out of your domain model, and put them inside a class called visitor.

It's a design trade off, but someone called it a design pattern, sigh!

##The Problem
imagine you decide all the eggs in your shop are selling at 0.8 discount, and all the drinks are selling at 0.9, and when customers check out, you need to write a method to calculate the total, you quickly bang out the following codes:

```java
abstract class Product {
    public float price;
    public abstract float getPrice();
}

class Egg extends Product {
   public Egg(float price)  {this.price = price;}
   public float getPrice() {
       return this.price * 0.8f;
   }
}

class Drinks extends Product {
    public Drinks(float price)  {this.price = price;}
    public float getPrice() {
        return this.price * 0.9f;
    }
}

public class Cal {
   public static float calPrice(List<Product> productList) {
      float total = 0f;
       for (Product p : productList) {
           total += p.getPrice();
       }
       return total;
   }
}
```

and for some unbearable reasons, you decided to move the price calculation logics outside your products:

```java
public class Visitor {
    public float calPrice(List<Product> productList) {
        float total = 0f;
        for (Product p : productList) {
            total += p.getPrice(this);
        }
        return total;
    }

    public float getPrice(Egg egg) {
        return egg.price * 0.8f;
    }


    public float getPrice(Drinks drinks) {
        return drinks.price * 0.9f;
    }
}

abstract class Product {
    public float price;

    public abstract float getPrice(Visitor visitor);
}

class Egg extends Product {
    public Egg(float price) {
        this.price = price;
    }

    public float getPrice(Visitor visitor) {
        return visitor.getPrice(this);
    }
}

class Drinks extends Product {
    public Drinks(float price) {
        this.price = price;
    }

    public float getPrice(Visitor visitor) {
        return visitor.getPrice(this);
    }
}

```
This is called a visitor, OMG.
