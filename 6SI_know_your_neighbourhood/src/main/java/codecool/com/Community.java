package codecool.com;

class Community extends AdministrativeUnit {

    public Community(String communityName, Integer communityNameNumber, String communityType) {
        this.Name = communityName;
        this.Number = communityNameNumber;
        this.Type = communityType;
    }

    public Integer getNameLength() {
        return  this.Name.length();
    }
}
