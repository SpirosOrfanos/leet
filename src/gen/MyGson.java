package gen;

import com.google.gson.Gson;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MyGson {
  public static void main(String[] args) {
      ProspectMedicalAppointmentVO vo = new ProspectMedicalAppointmentVO();
      vo.setId("setId");
      vo.setName("setName");
      vo.setAltName("setAltName");
      vo.setCpr("setCpr");
      vo.setMobile("setMobile");
      vo.setOptInsType("setOptInsType");
      vo.setDob(LocalDate.now().minusDays(10));
      vo.setApdDate(LocalDate.now());
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
      Optional.ofNullable(vo.getDob())
              .map(localDate -> formatter.format(localDate))
      .orElse(null);
      AppointmentDto dto = new AppointmentDto();
        dto.setCorrespondaceId(vo.getId());
        dto.setWorkerNameEnglish(vo.getName());
        dto.setWorkerNameArabic(vo.getAltName());
        dto.setDateOfBirth(Optional.ofNullable(vo.getDob())
            .map(localDate -> formatter.format(localDate))
            .orElse(null));
        dto.setApplicationDate(Optional.ofNullable(vo.getApdDate())
                .map(localDate -> formatter.format(localDate))
                .orElse(null));
        dto.setMobile(vo.getMobile());
        dto.setOptionalInsuranceType(vo.getOptInsType());
        dto.setCPR(vo.getCpr());
      Gson gson = new Gson();
    System.out.println(gson.toJson(dto));
  }
}


class AppointmentDto implements Serializable {
    private String correspondaceId;
    private String workerNameEnglish;
    private String workerNameArabic;
    private String dateOfBirth;
    private String applicationDate;
    private String mobile;
    private String optionalInsuranceType;
    private String CPR;

    public String getCorrespondaceId() {
        return correspondaceId;
    }

    public void setCorrespondaceId(String correspondaceId) {
        this.correspondaceId = correspondaceId;
    }

    public String getWorkerNameEnglish() {
        return workerNameEnglish;
    }

    public void setWorkerNameEnglish(String workerNameEnglish) {
        this.workerNameEnglish = workerNameEnglish;
    }

    public String getWorkerNameArabic() {
        return workerNameArabic;
    }

    public void setWorkerNameArabic(String workerNameArabic) {
        this.workerNameArabic = workerNameArabic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOptionalInsuranceType() {
        return optionalInsuranceType;
    }

    public void setOptionalInsuranceType(String optionalInsuranceType) {
        this.optionalInsuranceType = optionalInsuranceType;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }
}

class ProspectMedicalAppointmentVO {
    private String id;
    private String name;
    private String altName;
    private LocalDate dob;
    private String mobile;
    private LocalDate apdDate;
    private String optInsType;
    private String cpr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAltName() {
        return altName;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getApdDate() {
        return apdDate;
    }

    public void setApdDate(LocalDate apdDate) {
        this.apdDate = apdDate;
    }

    public String getOptInsType() {
        return optInsType;
    }

    public void setOptInsType(String optInsType) {
        this.optInsType = optInsType;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProspectMedicalAppointmentVO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", altName='").append(altName).append('\'');
        sb.append(", dob='").append(dob).append('\'');
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", apdDate='").append(apdDate).append('\'');
        sb.append(", optInsType='").append(optInsType).append('\'');
        sb.append(", cpr='").append(cpr).append('\'');
        sb.append('}');
        return sb.toString();
    }
}