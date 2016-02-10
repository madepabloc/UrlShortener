package com.util.shortener

import org.apache.commons.codec.binary.Base64

import javax.xml.bind.DatatypeConverter

/**
 * Created by migdepcas on 8/02/16.
 */
class ShortenerUtils {


    /**
     * @Miguel Angel de Pablo
     * @param id -> id to encode
     * @return idEncoded
     * Util method to encode an int id
     * **/
    static String encodeId(int id){
        String idEncoded
        def bytes,bytesCoded

        bytes = (id as String).getBytes()
        bytesCoded = Base64.encodeBase64(bytes)


        idEncoded=DatatypeConverter.printBase64Binary(bytesCoded)

    }


    /**
     * @author Miguel Angel de Pablo
     * @param encodedId -> String encoded
     * @return idDecoded as Integer -> initial id decoded
     * Util methot to decode an encoded Integer
     * **/
    static int decodeId(String encondedId){
        def bytes,bytesDecoded
        String idDecoded

        bytes=DatatypeConverter.parseBase64Binary(encondedId)
        bytesDecoded=Base64.decodeBase64(bytes)
        idDecoded = new String(bytesDecoded)

        return (idDecoded as Integer)
    }


    /**
     * @author Miguel Angel de Pablo
     * @param host -> Host where app is deployed
     * @param appName -> App name defined in application.properties
     * @param idEncoded -> id encoded
     * @return Complete shorten url
     * **/
    static String buildUrlShortened(String host, String appName, String idEncoded){
        String shortUrl

        shortUrl = "${host}${appName}/~/${idEncoded}"

        return shortUrl
    }



}
