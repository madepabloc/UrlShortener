package projecturl

import com.util.shortener.ShortenerUtils
class ShortenerController {
    def shortenerService
    def grailsApplication


    def index(){
    }


 /**
  * @author Miguel Angel de Pablo
  * Form submit action to shorten the url
  *
  * **/
    def shortenUrl(){
        String largeURL,idEncoded,shortUrl,appName,host
        int rowDbId

        appName = grailsApplication.applicationMeta."app.name"
        host = grailsApplication.config.app.host
        largeURL = params.largeUrl

//        save urlRecord in db and get the id
        rowDbId = shortenerService.saveUrl(largeURL)


//        encode the id to generate the shorten url
        idEncoded=rowDbId ? ShortenerUtils.encodeId(rowDbId) : (render(template: '/shortener/showUrlShortened',model: [data: "${message(code: 'shortener.error')}"]))

//        build url Shortened
        shortUrl = ShortenerUtils.buildUrlShortened(host,appName,idEncoded)

//        update urlRecord with the urlShortened
        shortenerService.updateUrlRow(rowDbId,shortUrl)


        log.info("${largeURL} -> ${shortUrl}")
        render(template: '/shortener/showUrlShortened',model: [data: shortUrl])
    }

}
