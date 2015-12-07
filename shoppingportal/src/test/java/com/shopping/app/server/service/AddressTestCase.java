package com.shopping.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shopping.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shopping.app.server.repository.AddressRepository;
import com.shopping.app.shared.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.shopping.app.shared.location.AddressType;
import com.shopping.app.server.repository.AddressTypeRepository;
import com.shopping.app.shared.location.City;
import com.shopping.app.server.repository.CityRepository;
import com.shopping.app.shared.location.Country;
import com.shopping.app.server.repository.CountryRepository;
import com.shopping.app.shared.location.State;
import com.shopping.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("poK5mY0ITp6stm0v0VI2Ftn4NccrYVlnNwuy7CnwLNY2JYKruD");
            addresstype.setAddressTypeDesc("4anOEScUsslqDquPTCJgnO8lYriT9afBZaGJU4u7oIwcc9BZg7");
            addresstype.setAddressTypeIcon("edrdC7MTGZL26RJwKS7rMQLPNnjJ2P9DZQ8XRyBGZ1xi6seAio");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("8o6p3Dhm2D3RgI63afwkdH5wJhAAh2co");
            city.setCityDescription("tOPPeNOt2JFz7ecNJW9ZF2xrmxNrkztvnHNotq3NJ1Fv5qFfZb");
            city.setCityFlag("8FqtGP7T2l7mlx5AXsD3EK22a3NNSGatQ2oX4aMAicJqHnXU1N");
            city.setCityLatitude(11);
            city.setCityLongitude(11);
            city.setCityName("uwzGScguz1tvIue038cTAa6hzH7dRrIKyLb6ttWs0600gKx3xe");
            Country country = new Country();
            country.setCapital("H0aGRY4G1KXu27b6r2haVrIAe0iGBQTm");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(8);
            country.setCountryCode1("HaF");
            country.setCountryCode2("0tA");
            country.setCountryFlag("UjpGJyM0DhTL1XZHfnSJcPqy8JPmCNFn79zOPlg1E7Mvdl4e2B");
            country.setCountryName("xyretPqqluiEkq2GBc9GAaKBWGQTod6wP9XYPIIVYkGpve31Du");
            country.setCurrencyCode("dct");
            country.setCurrencyName("OMHnseBbr0HfU7Z0nQdpyMZynNI9bbm6mv9LPMgXNomQI6QhHK");
            country.setCurrencySymbol("oyeBqNSZFMrovn8OnO0gVJzz7YgCuU7P");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("S1J9YhwAEUA0odledtjdwVAPaPqGYYJr2UyOgpLXFGHMsMgCw8");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(5);
            state.setStateCode(2);
            state.setStateCodeChar2("vPcyFDbRV7x6yTc0nx7J2TOwUKjYrzYF");
            state.setStateCodeChar3("WgeLyxtdgxn4xjquY6xGchH2R76mNicw");
            state.setStateDescription("a2LI64iU8dRBOMg6pO89TUlLJdsPHmpqfbS60KoSddDx2qI88X");
            state.setStateFlag("yMwDmHErBEzeiCJbrCniR8dtVAqioTaHeZ8VslGuGPW3MAUM7c");
            state.setStateName("NKr4gBSx9t68R8Hl9tjIhGAkVV9R2E6eSPCwkR9rFEXLZwzHyt");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("IBBq7C5wT3O8sZLKO6FpT968bK4MYM1o");
            city.setCityDescription("wLM1qJZU7DHuUl2o3NPfYprv9Bvd1lfAlA8UyudhP4344XeMx7");
            city.setCityFlag("KsngkgDTwQlORkfabZeEQZjiywLKZxqIKDLNqTGaDmEEUDHCTT");
            city.setCityLatitude(6);
            city.setCityLongitude(3);
            city.setCityName("D33LlSMU8Rf3xXqmAIF79AzBF6Xz5N3F5mMu5eu8UEnizwvwvX");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("UnGZOo7egh8whGsoVCTV0yzrpgnisCYJc0L8mQX6FEopbOUeco");
            address.setAddress2("nIvhNNJZDQp9makJ6abx59wApEIrwGgjL92P4SomschLxaNQtt");
            address.setAddress3("dLkvPVctuC8EIqhjZwymsghk7UM1rhzTgsJECrbeKuexhVJKPA");
            address.setAddressLabel("tk4c61LzGJz");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("gLo0kSfRoXKZcVHqgjWouCRmpSJJeL0IT3v1BOFztKh3JiBYAx");
            address.setLongitude("FQkNUuaPT6OoBS4js3eRzK8Dz0HB5IE3HkuRY3QnyN81SIbt4C");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("kl1SOk");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("As7YcTE085tumkBn8lbICKOTVp9s2gdgprZGKKFfYRAnrg8tzM");
            address.setAddress2("TRsp8jk1mhnfCQ1ci6UBwbVPcIjYJx1Y0bZYF1leKYfuGGa3j9");
            address.setAddress3("1ptvkdZTxrUe2mlPpu6XcgK4RxjY1VDdlKdvD7cEM9ZvZ8oRKQ");
            address.setAddressLabel("dZ7JNqT4zw5");
            address.setLatitude("ezoDtWHaL0BOTYg7tD0tr02EQDClQRdTvVramHxCws6STytAwd");
            address.setLongitude("3PiFYiTrlW8dRVmmvycwPrIn4ZKbiytSYru7V65G1nUDwxJx42");
            address.setVersionId(1);
            address.setZipcode("twxsuV");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
