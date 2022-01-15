package helper;

import java.time.LocalDateTime;
import java.util.*;

public class DateUtils {
    public static void main(String... args) {
    System.out.println(lcdMinusDays(0));
    System.out.println(lcdMinusDays(10));
        List<BrIdentificationD> li = new ArrayList<>();
        BrIdentificationD ll = new BrIdentificationD();
        ll.setPartyIdentifierTypeId("ESN");
        li.add(ll);
        ssss(li);
    }

    private static void ssss(List<BrIdentificationD> identificationDList) {
        BrIdentificationD establishmentNumber = identificationDList.stream()
                .filter(p -> p.getPartyIdentifierTypeId().equals("ESN"))
                .findFirst()
                .orElse(null)
               ;// .getIdentificationValue();
    System.out.println(establishmentNumber);
    }
    private static LocalDateTime lcdMinusDays(int minus) {
        return LocalDateTime.now().minusDays(minus);
    }
}

class BrIdentificationD {

  public Long identificationId;
  public String identificationValue;
  public Long partyId;
  public Long partyRoleId;
  public String partyIdentifierTypeId;

    public Long getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(Long identificationId) {
        this.identificationId = identificationId;
    }

    public String getIdentificationValue() {
        return identificationValue;
    }

    public void setIdentificationValue(String identificationValue) {
        this.identificationValue = identificationValue;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public Long getPartyRoleId() {
        return partyRoleId;
    }

    public void setPartyRoleId(Long partyRoleId) {
        this.partyRoleId = partyRoleId;
    }

    public String getPartyIdentifierTypeId() {
        return partyIdentifierTypeId;
    }

    public void setPartyIdentifierTypeId(String partyIdentifierTypeId) {
        this.partyIdentifierTypeId = partyIdentifierTypeId;
    }
}


class Product {
    int id;
    String name;

    public Product(int i, String n) {
        id = i; name = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
/* @Override
    public boolean equals(Product p) {
        return (p != null)
                && (p.id==id)
                && (p.name.equals(name));
    }*/
}

class Ex2<T extends Runnable, R> {
    String s = "Hello";
    public void test(T t) {
           t.run();
        }
 }

