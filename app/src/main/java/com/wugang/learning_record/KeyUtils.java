package com.wugang.learning_record;

import android.util.Base64;
import android.util.Log;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Created by wugang on 2017/8/8.
 */

public class KeyUtils {
//    public static void main(String args[]){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    rsaEncrypt("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzbDjrE7icKKvNX2y0Ua6VpIw7\n" +
//                            "78XRz85ZEiN/gp2LyOv8pxo7cWLknFB4Y3QQxx3Sq5xIRdEyplISKgRKH50dIjyC\n" +
//                            "vlQ3hXHGs4xUlAaJgs52oUYwL6GBm1K+EHYSCcDGaswK8qfp3QEiCjllA3exzVv8\n" +
//                            "/GmUdIb9m3J4/UMdBQIDAQAB","");
//                } catch (NoSuchAlgorithmException e) {
//                    e.printStackTrace();
//                } catch (InvalidKeySpecException e) {
//                    e.printStackTrace();
//                } catch (NoSuchPaddingException e) {
//                    e.printStackTrace();
//                } catch (InvalidKeyException e) {
//                    e.printStackTrace();
//                } catch (IllegalBlockSizeException e) {
//                    e.printStackTrace();
//                } catch (BadPaddingException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//    }
    public static String rsaEncrypt(String paramString1, String paramString2) throws NoSuchAlgorithmException, InvalidKeySpecException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
         KeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(paramString1, 2));
         PublicKey rsa = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
         Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
         localCipher.init(1, rsa);
        Log.d("签名秘钥",Base64.encodeToString(localCipher.doFinal("18565727169".getBytes()), 2).trim());

        return Base64.encodeToString(localCipher.doFinal(paramString2.getBytes()), 2).trim();
    }
}
