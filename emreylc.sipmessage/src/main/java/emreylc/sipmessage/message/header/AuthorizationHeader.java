package emreylc.sipmessage.message.header;

import emreylc.sipmessage.message.authenticate.creditial.DigestResponse;

public class AuthorizationHeader extends SipMessageHeader {

    // Authorization: Digest username="bob", realm="atlanta.example.com"
    // ; nonce="ea9c8e88df84f1cec4341ae6cbe5a359", opaque="",
    // ; uri="sips:ss2.biloxi.example.com",
    // ; response="dfe56131d1958046689d83306477ecc"
    private DigestResponse digestResponse;
}
