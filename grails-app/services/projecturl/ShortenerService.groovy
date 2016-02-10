package projecturl

class ShortenerService {


    /**
     * @author Miguel Ángel de Pablo
     * @param largeUrl: String of the large URL
     * @return record.id: Id of the row creation.
     *
     * Method that insert in db a record of a large url
     *
     * **/
    def saveUrl(String largeUrl) {
        UrlRecord record
        try {
            record = new UrlRecord(urlComplete: largeUrl)
            record=record.save()
        }catch (Exception e){
            log.error("Error shortening ${largeUrl}")
            record
        }

        record.id

    }


    def updateUrlRow(int id,String shortUrl){
        UrlRecord urlRecord

        urlRecord = UrlRecord.get(id)
        urlRecord.lock()
        urlRecord.urlShorted=shortUrl
        urlRecord.save()
    }

    def boolean  existsUrlShortened(String urlComplete){
        int count

        count =  UrlRecord.createCriteria().count {
            eq('urlComplete',urlComplete)
        }

        count > 0

    }
}
