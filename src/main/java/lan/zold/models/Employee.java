package lan.zold.models;

public class Employee {
  
  public Integer id;
  public String name;
  public String city;
  public Double salary;

  public Employee(int id, String name, String city, double salary) {
      this.id = id;
      this.name = name;
      this.city = city;
      this.salary = salary;
  }

  public javafx.beans.property.IntegerProperty idProperty() {
      return new javafx.beans.property.SimpleIntegerProperty(id);
  }

  public javafx.beans.property.StringProperty nameProperty() {
      return new javafx.beans.property.SimpleStringProperty(name);
  }

  public javafx.beans.property.StringProperty cityProperty() {
      return new javafx.beans.property.SimpleStringProperty(city);
  }

  public javafx.beans.property.DoubleProperty salaryProperty() {
      return new javafx.beans.property.SimpleDoubleProperty(salary);
  }
  
}
