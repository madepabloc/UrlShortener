package projecturl

class UrlRecord {

    String urlShorted
    String urlComplete
    Date dateCreated


    static constraints = {
        urlComplete blank: false,nullable: false
        urlShorted blank: false,nullable: true
    }


}
