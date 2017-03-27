package telemetry.assettocorsa.zotyt.actelemetrymonitor.networkservice;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import telemetry.assettocorsa.zotyt.actelemetrymonitor.data.TelemetryData;

/**
 * Created by zotyt on 2017. 03. 17..
 */

public final class UdpHandler {

    private static int defPortNumber = 9666;
    private static int defPacketSize = 3000;
    private DatagramSocket udpSocket;
    private DatagramPacket udpPacket;
    private boolean defPortUsed = true;
    private TelemetryData telemetry = null;



    private void initializeReal (int otherPort, int _packetSize) throws SocketException{
        udpSocket = new DatagramSocket(otherPort);
        byte[] readedArray = new byte[_packetSize];
        udpPacket = new DatagramPacket(readedArray, readedArray.length);
    }
    /* use this method if u want to start udp Client in not predefined port (9666), or in predefined packet size (784);
    * otherport -> port number
    * _packetSize ->  the packet size
    * if some of the variables are equal 0, then it gonne be substitute with predefined values
    * **/
    public void initialize(int otherPort, int _packetSize) throws SocketException{
        defPortUsed = false;
        if(otherPort == 0){
            otherPort = defPortNumber;
            defPortUsed = true;
        }

        if(_packetSize == 0){
            _packetSize = defPacketSize;
        }
        initializeReal(otherPort, _packetSize);
    }

    /* use this method if u want to start udp Client in predefined port (9666), and in predefined packet size (784);
    *
    * **/
    public void initialize() throws SocketException{
        defPortUsed = true;
        initializeReal(defPortNumber, defPacketSize);
    }

    public void close(){
        udpSocket.close();
    }

    public void setTelemetry(TelemetryData _d){
        telemetry = _d;
    }

    public int getPort(){
        if(defPortUsed){
            return defPortNumber;
        }
        else{
            return udpSocket.getPort();
        }
    }

    public int getPocketSize(){
        return udpPacket.getLength();
    }

    public void startDataCollecting() throws IOException, JSONException{
        udpSocket.receive(udpPacket);
        byte[] packet = udpPacket.getData();
        String text = new String(packet, 0, packet.length);
        Log.d("TELEMETRIA:::",text);
        JSONObject jsonObject = new JSONObject(text);
        Log.d("SPEED: ", jsonObject.getString("speedKmh"));
        JSONArray jsonArray = jsonObject.getJSONArray("tyreTempInner");

        telemetry.frontLeft.innerTemp = (float)jsonArray.getDouble(0);
        telemetry.frontRight.innerTemp = (float)jsonArray.getDouble(1);
        telemetry.rearLeft.innerTemp = (float)jsonArray.getDouble(2);
        telemetry.rearRight.innerTemp = (float)jsonArray.getDouble(3);

        jsonArray = jsonObject.getJSONArray("tyreTempCenter");

        telemetry.frontLeft.medTemp = (float)jsonArray.getDouble(0);
        telemetry.frontRight.medTemp = (float)jsonArray.getDouble(1);
        telemetry.rearLeft.medTemp = (float)jsonArray.getDouble(2);
        telemetry.rearRight.medTemp = (float)jsonArray.getDouble(3);

        jsonArray = jsonObject.getJSONArray("tyreTempOuter");

        telemetry.frontLeft.outerTemp = (float)jsonArray.getDouble(0);
        telemetry.frontRight.outerTemp = (float)jsonArray.getDouble(1);
        telemetry.rearLeft.outerTemp = (float)jsonArray.getDouble(2);
        telemetry.rearRight.outerTemp = (float)jsonArray.getDouble(3);

        telemetry.performanceMeter = (float)jsonObject.getDouble("performanceMeter");

        jsonArray = jsonObject.getJSONArray("brakeTemp");
        telemetry.frontLeft.brakeTemperature = (float)jsonArray.getDouble(0);
        telemetry.frontRight.brakeTemperature = (float)jsonArray.getDouble(1);
        telemetry.rearLeft.brakeTemperature = (float)jsonArray.getDouble(2);
        telemetry.rearRight.brakeTemperature = (float)jsonArray.getDouble(3);

        jsonArray = jsonObject.getJSONArray("tyreCoreTemp");
        telemetry.frontLeft.coreTemp = (float)jsonArray.getDouble(0);
        telemetry.frontRight.coreTemp = (float)jsonArray.getDouble(1);
        telemetry.rearLeft.coreTemp = (float)jsonArray.getDouble(2);
        telemetry.rearRight.coreTemp = (float)jsonArray.getDouble(3);

        jsonArray = jsonObject.getJSONArray("tyreWear");
        telemetry.frontLeft.wear = (float)jsonArray.getDouble(0);
        telemetry.frontRight.wear = (float)jsonArray.getDouble(1);
        telemetry.rearLeft.wear = (float)jsonArray.getDouble(2);
        telemetry.rearRight.wear = (float)jsonArray.getDouble(3);

        jsonArray = jsonObject.getJSONArray("wheelPressure");
        telemetry.frontLeft.pressure = (float)jsonArray.getDouble(0);
        telemetry.frontRight.pressure = (float)jsonArray.getDouble(1);
        telemetry.rearLeft.pressure = (float)jsonArray.getDouble(2);
        telemetry.rearRight.pressure = (float)jsonArray.getDouble(3);

        telemetry.notifyProp();
    }

}
