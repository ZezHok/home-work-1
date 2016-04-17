package ru.stqa.homework.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Yulia on 17.04.2016.
 */
public class GeoIpServiceTests {

  @Test
  public void testMyIp(){
    GeoIP geoIp = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("109.252.69.240");
    assertEquals(geoIp.getCountryCode(),"RUS");
  }


}
