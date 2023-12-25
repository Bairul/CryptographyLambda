package lambda;

import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        String crypt = "55AE8026639C6EF095E7C4409E2CCB160BE85211A9C7B976101988993A9EE0C915DDF36BE91D6CE72BDB33C16FBFDC7DF33879A167B992A6D612EE99D53DE970F0AE47E3EDCFACBB040206F9029C9F03C04D48FF6C32123DF1D57E5BAD10FE9E92301E9926E5031105847E4E3F872C15562E27F9EC32C68405F199557CFE0FC32FA31D57";
        String pass = "Bairu";

        byte[] dec = KMAC.decrypt(ByteStringUtil.hexToBytes(crypt), pass);
        byte t_equals_t_prime = dec[dec.length - 1];
        dec = Arrays.copyOf(dec, dec.length - 1);

        // accept if and only if t = t'
        if (t_equals_t_prime == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
