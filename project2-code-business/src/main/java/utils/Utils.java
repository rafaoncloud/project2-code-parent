package utils;


import org.dozer.DozerBeanMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Utils {

    private static Logger loggerSingleton = null;

    private static DozerBeanMapper dozerBeanMapperSingleton = null;

    public static final String[] USERS_TABLE = {"Manager", "User"};

    public static Logger getLogger() {
        //Singleton
        if (loggerSingleton == null)
            loggerSingleton = LoggerFactory.getLogger( "BussinessLayer" );

        return loggerSingleton;
    }

    public static DozerBeanMapper getDozerBeanMapper() {
        //Singleton
        if (dozerBeanMapperSingleton == null)
            dozerBeanMapperSingleton = new DozerBeanMapper();

        return dozerBeanMapperSingleton;
    }

    public static String ascOrDesc(boolean ascend) {
        if (ascend)
            return " asc";

        return " desc";
    }


    public static String sha1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest crypt = MessageDigest.getInstance( "SHA-1" );
        crypt.reset();
        crypt.update( text.getBytes( "UTF-8" ) );

        return new BigInteger( 1, crypt.digest() ).toString( 16 );

    }
}
