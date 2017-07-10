package emreylc.sipmessage.message.header.parameter;

public class ViaParameter {

    private int viaTtl = -1;
    private String maddr;
    private String branch;
    private String recieved;
    private String compression;
    private int rport = -1; // 0 = ;rport; , -1: none , other: ;rport:3333
    private String sigCompID;
    private String alias;
    private String keep;
    private String oc;
    private String ocValidity;
    private String ocSeq;
    private String ocAlgo;
    private String receivedRealm;
    private GenericParam genericParam;

}
