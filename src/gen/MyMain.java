package gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static gen.ChainedProperty.*;
import static gen.ChainedProperty.Util.*;

public class MyMain {
    public static void main (String... args) {
   /* chain()
        .enlist(
            forInteger()
                .add(addIntProperty(() -> "k1", () -> 122))
                .add(addIntProperty(() -> "k2", () -> 123))
                .add(addIntProperty(() -> "k3", () -> 124))
                .add(addIntProperty(() -> "k3", () -> 125)))
        .enlist(
            forString()
                .add(addStringProperty(() -> "k1-2", () -> "122-111"))
                .add(addStringProperty(() -> "k2-2", () -> "123-111"))
                .add(addStringProperty(() -> "k3-2", () -> "124-111"))
                .add(addStringProperty(() -> "k3-2", () -> "125-111")))
        .enlist(forCollection().add(addCollectionProperty(() -> "dddd", () -> Arrays.asList(new String[]{"aa", "bb"}))))
        .get()
        .stream()
        .forEach(
            chb -> {
              List<SspDynamicProperty> l = chb.getProps();
              l.stream()
                  .forEach(
                      i ->
                          System.out.println(
                              chb.getType() + "" + i.getName() + " : " + i.getValue()));
            });*/


        chain().enlist(forString()
                .add(addStringProperty(() -> "correspondaceId", () -> "dto.getCorrespondaceId()"))
                .add(addStringProperty(() -> "workerNameEnglish", () ->" dto.getWorkerNameEnglish()"))
                .add(addStringProperty(() -> "workerNameArabic", () -> "dto.getWorkerNameArabic()"))
                .add(addStringProperty(() -> "dateOfBirth", () -> " dto.getDateOfBirth()"))
                .add(addStringProperty(() -> "applicationDate", () -> "dto.getApplicationDate()"))
                .add(addStringProperty(() -> "mobile", () -> "dto.getMobile()"))
                .add(addStringProperty(() -> "optionalInsuranceType", () -> "dto.getOptionalInsuranceType()"))
                .add(addStringProperty(() -> "optionalInsuranceType", () -> "dto.getCPR()"))
        ).get().forEach(chainBuilder -> {
            List<SspStringProperty> props = chainBuilder.getProps();
            props.stream().forEach(prop ->System.out.println(prop.getName()  + " : " +  prop.getValue()));
        });

       /* List<SspDynamicProperty> l =  forInteger()
                .add(addStr(() -> "k1", () -> 122))
                .add(addStr(() -> "k2", () -> 123))
                .add(addStr(() -> "k3", () -> 124))
                .add(addStr(() -> "k3", () -> 125))
        .getProps();
        l.stream().forEach(i -> System.out.println(i.getName() + " : " + i.getValue()));
        l.stream().forEach(i -> System.out.println(i.getName() + " : " + i.getValue()));*/
    }


}
