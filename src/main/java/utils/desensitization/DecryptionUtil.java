package utils.desensitization;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DecryptionUtil {

    // 24位，中金支付有限公司
    private static final byte[] KEY_DATA = new byte[]{-28, -72, -83, -23, -121, -111, -26, -108, -81, -28, -69, -104, -26, -100, -119, -23, -103, -112, -27,
            -123, -84, -27, -113, -72};

    // 8位，Cpcn1@34
    private static final byte[] IV_DATA = new byte[]{67, 112, 99, 110, 49, 64, 51, 52};

    public static final String DEFAULT_CHARSET = "UTF-8";

    public static String des3CBCDecrypt(String cipherText) {
        String plainText = null;

        try {
            if (null != cipherText && cipherText.length() > 0) {
                byte[] decryptStr = des3CBCDecrypt(IV_DATA, KEY_DATA, hex2bytes(cipherText));
                if (decryptStr != null) {
                    plainText = new String(decryptStr);
                }
            }
        } catch (Exception e) {
            System.err.println("DecryptCipher Exception:- " + e);
        }
        return plainText;
    }

    public static byte[] des3CBCDecrypt(byte[] ivData, byte[] keyData, byte[] cipherText) {
        SecretKeySpec key3Des = new SecretKeySpec(keyData, "DESede");
        IvParameterSpec ivSpec = new IvParameterSpec(ivData);
        byte[] plainText = null;

        try {
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key3Des, ivSpec);
            plainText = cipher.doFinal(cipherText);
        } catch (Exception e) {
            System.err.println("DecryptCipher Exception:- " + e);
        }
        return plainText;
    }

    /**
     * 脱敏存储用加密，固定密钥和偏移量，输入明文串，返回十六进制密文串
     *
     * @param plainText
     * @return
     * @author shengsu
     */
    public static String des3CBCEncrypt(String plainText) {
        String cipherText = null;
        try {
            if (null != plainText && plainText.length() > 0) {
                cipherText = bytes2hex(des3CBCEncrypt(IV_DATA, KEY_DATA, plainText.getBytes(DEFAULT_CHARSET)));
            }
        } catch (Exception e) {
            System.err.println("EncryptCipher Exception:- " + e);
        }
        return cipherText;
    }

    public static byte[] des3CBCEncrypt(byte[] ivData, byte[] keyData, byte[] plainText) {
        SecretKeySpec key3Des = new SecretKeySpec(keyData, "DESede");
        IvParameterSpec ivSpec = new IvParameterSpec(ivData);
        byte[] cipherText = null;
        try {
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key3Des, ivSpec);
            cipherText = cipher.doFinal(plainText);
        } catch (Exception e) {
            System.err.println("EncryptCipher Exception:- " + e);
        }
        return cipherText;
    }

    private static byte[] hex2bytes(String hexStringParam) {
        String hexString = hexStringParam;

        // 转换成大写
        String hexStringUpper = hexString.toUpperCase();

        // 计算字节数组的长度
        char[] chars = hexStringUpper.toCharArray();
        byte[] bytes = new byte[chars.length / 2];

        // 数组索引
        int index = 0;

        for (int i = 0; i < chars.length; i += 2) {
            byte newByte = 0x00;

            // 高位
            newByte |= char2byte(chars[i]);
            newByte <<= 4;

            // 低位
            newByte |= char2byte(chars[i + 1]);

            // 赋值
            bytes[index] = newByte;

            index++;
        }
        return bytes;
    }

    private static byte char2byte(char ch) {
        switch (ch) {
            case '0':
                return 0x00;
            case '1':
                return 0x01;
            case '2':
                return 0x02;
            case '3':
                return 0x03;
            case '4':
                return 0x04;
            case '5':
                return 0x05;
            case '6':
                return 0x06;
            case '7':
                return 0x07;
            case '8':
                return 0x08;
            case '9':
                return 0x09;
            case 'A':
                return 0x0A;
            case 'B':
                return 0x0B;
            case 'C':
                return 0x0C;
            case 'D':
                return 0x0D;
            case 'E':
                return 0x0E;
            case 'F':
                return 0x0F;
            default:
                return 0x00;
        }
    }

    public static String bytes2hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        String b = "";
        if (null == bytes) {
            return null;
        }
        for (int i = 0; i < bytes.length; i++) {
            b = Integer.toHexString(bytes[i] & 0xFF);
            if (b.length() == 1) {
                b = "0" + b;
            }
            result.append(b);
        }
        return result.toString().toUpperCase();
    }


}
