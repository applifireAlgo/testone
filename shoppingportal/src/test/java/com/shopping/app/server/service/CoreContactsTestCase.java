package com.shopping.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shopping.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shopping.app.server.repository.CoreContactsRepository;
import com.shopping.app.shared.contacts.CoreContacts;
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
import com.shopping.app.shared.contacts.Gender;
import com.shopping.app.server.repository.GenderRepository;
import com.shopping.app.shared.location.Language;
import com.shopping.app.server.repository.LanguageRepository;
import com.shopping.app.shared.location.Timezone;
import com.shopping.app.server.repository.TimezoneRepository;
import com.shopping.app.shared.contacts.Title;
import com.shopping.app.server.repository.TitleRepository;
import com.shopping.app.shared.location.Address;
import com.shopping.app.server.repository.AddressRepository;
import com.shopping.app.shared.location.AddressType;
import com.shopping.app.server.repository.AddressTypeRepository;
import com.shopping.app.shared.location.City;
import com.shopping.app.server.repository.CityRepository;
import com.shopping.app.shared.location.Country;
import com.shopping.app.server.repository.CountryRepository;
import com.shopping.app.shared.location.State;
import com.shopping.app.server.repository.StateRepository;
import com.shopping.app.shared.contacts.CommunicationData;
import com.shopping.app.shared.contacts.CommunicationGroup;
import com.shopping.app.server.repository.CommunicationGroupRepository;
import com.shopping.app.shared.contacts.CommunicationType;
import com.shopping.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("mwPu5vYtOk7u5Y7ywueVB4q9ylyb7txHH3ruzftuUlhafyYuvq");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("i3");
            language.setAlpha3("Ype");
            language.setAlpha4("vMV0");
            language.setAlpha4parentid(2);
            language.setLanguage("v9YKLO0j41JOq8eS6daFiU2kJd1mb2X6uBEDIq576b05w4a3pF");
            language.setLanguageDescription("yY84U9ISAhmS1byJVasHhoMe7lOMCalvJ1YsqdJaDoThVllg7F");
            language.setLanguageIcon("qYiY7yWWY7WgHNfvVF6m0RqqVDhC1g8HcRGDCAfXAccELfFe6Y");
            language.setLanguageType("DJ6lARTFGxvao1PteVxyoJ6ui2LaquX8");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("cTyYVvt7ntIHPijOwueqNQRrPpezrUj2pZB3mAlLVMrHTt916g");
            timezone.setCountry("hSjr8C6Ph499YjAxnS3V8k9Gra4f1LPLVNbGxrgyPT5aXYEZNW");
            timezone.setGmtLabel("znXMOqdApIjlb9JVJXr2fOtLw0xvLhC7xtxyCSUG1XwwIWZwQ4");
            timezone.setTimeZoneLabel("eci3P3mWNBrR8aQB4GNvE9dGhw2Z9NJeVvfzivejVgTVYpBNz8");
            timezone.setUtcdifference(1);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("Vf7FxJEFSTOD9jhp9rvdRPOat9MwkgKBEeWbmtQnE8DknZbbgH");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(53);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("MjJlFVnLbvKJ4R7Vb0Cs5pocWk9bHKKNSZZTlm3e8fswKHDhwW");
            corecontacts.setFirstName("ggt0ohKFu7IRiIHy6t8nvtGyErPQis1nESj9h1NFAwlwW2Apwy");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("00xVjcWXWZQYOuh1F5rpY0u3ZU1YAv87RgcjWJlUPT0BHmpwhH");
            corecontacts.setMiddleName("436lRhLMPMgH1hxKqlSQrO4fgIbxGNjNaijjymTFUetQ5RcvVL");
            corecontacts.setNativeFirstName("4VmwrKxsuhQQh1onK2q05tfsgi0ZwMqIPkmI1npwPM7fDkSAKa");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("lhr6G40796FiSxkCkp2nO5Mybep6FyTyC61YtFIqCjFTgEQjkV");
            corecontacts.setNativeMiddleName("h1nm4Bzr3kThzgE0CUGo5yG4g3he70Q1EGTduKo2kB7iYWTGmk");
            corecontacts.setNativeTitle("n8sdPhM7md4z6YyQRDvzGd6RQBANAOUPvQVetSLdySmbmozbeF");
            corecontacts.setPhoneNumber("KM5yeZMcsoQmRE85I4zF");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("J8rQw6ZfAnZN1hb7nPLTfRwRmCJByCY8Dtzvdlag5o1VPOzeaF");
            address.setAddress2("YubqnzdgAsOkk9hssY7dcAq100ypsT568JJcPM8tFTsrsQw5iw");
            address.setAddress3("JiDMz1aBLnMA31s5DnChX3Sj688LfZ8TpaxCcLLR54V0kzGdKo");
            address.setAddressLabel("0C8V5kIPQCm");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("YR08jPKUwbMzlFC3MYQVJXrPwHaFVozpnlq9zPAJ3EMmUGvG25");
            addresstype.setAddressTypeDesc("12vCuOqD7AnBZB2Xp4bmpkbY619rMMkBjGBDuw4RGdq5y5mlBt");
            addresstype.setAddressTypeIcon("8XYV3ZrhgdQgX1A8SEZjDlF4MnXI9VTSENVgdM1pP5rKJwpw64");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("nBmaoEcT9jPk7Hhkjvs32NWh0IBiiehF");
            city.setCityDescription("sLLMJDuiF6tE5zRD6cJlqh4c0hkjfMRelKBfaHUotr8jNFgvpA");
            city.setCityFlag("ivt7gsKGi4EGszEu5aH98PEbZQBcImZbu1eg5bb6CSHg9MurOC");
            city.setCityLatitude(0);
            city.setCityLongitude(1);
            city.setCityName("NiD9T9JP2PI7IGsYZBk3azZE54joMMEv2E3ZRBMR61PUxUQIQO");
            Country country = new Country();
            country.setCapital("UgGPk5EUIPonCOGDE41opGRuBE6NM5G8");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(8);
            country.setCountryCode1("PTf");
            country.setCountryCode2("uLv");
            country.setCountryFlag("XIc4Kpe0j4DjELe7529gYAZDaP8QvXDwyQn9LqLc07crg7sNI1");
            country.setCountryName("APWuqglhMLcUDdPxfitosFnHfKnqiXpFwR4xQf8iyF2laknarP");
            country.setCurrencyCode("2i7");
            country.setCurrencyName("VFyVuwgREN18GaymeObW7q4o44oPDcyjCKCGjraW6uoTxZTdWf");
            country.setCurrencySymbol("3lZ5WKtCjHHO9LsgmUkSzWFzVILp1so0");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("fffs1lEheu5N4kJKbfiuXB8PtlsMFf4O9nuxM0YgjolZLTXVSl");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(11);
            state.setStateCode(2);
            state.setStateCodeChar2("d9RGcz1DolDL8n2zMZPiTQBwnkDtjcS1");
            state.setStateCodeChar3("5pNMnjse8uanfscYULRvfAOJaevC3GXn");
            state.setStateDescription("ZfqgulnhcWTOKelVqLqmrgtYjVB74DnNa56fmAFTbpcPOpAgqN");
            state.setStateFlag("9UCy3C8iNbxm3BYTQbnEU6BJl8BGjfnI7QOfnPRnf1esktbY29");
            state.setStateName("7jR1iEoMZwGPsXEPcnp8odBQkXfiDCakJVUrBQfabvyE9pMFl2");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("cklbzPIQBpxCp5QvCthAGrjmxyQrB7JX");
            city.setCityDescription("KqpHHJs0v6hkBb78pKD6smRRaJZ6Gc6zZTtuiSjgfo5K1PTxw4");
            city.setCityFlag("ckdMOUaomaGkK7hjeG4Lh6nNjudXTMzjuD6P0XorBlXwXXua1V");
            city.setCityLatitude(4);
            city.setCityLongitude(0);
            city.setCityName("SyEnt335LaTa1qnDss9zCUVjOXGF9q41hcv9rOuqgqfKALWsly");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("jD30o4hZsIHg8L8TsbCdcCfMCtemBJYwj3HjpvvtSyrEUrqv0q");
            address.setAddress2("XWLBpgQq2imv2BsndRhny5fASapLUlr7mB5E6QtigteGugpmvd");
            address.setAddress3("umIvf4emn6QBpPiZKtxvK1MvizIRA6yRVmMNLvYGYAoGgPboNW");
            address.setAddressLabel("OkUCXcVsh8t");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("xro6pWw9cmhzq3YAQUT2dfu8kt2rnJhI1qUizQg34hUjKByGN6");
            address.setLongitude("gFF0Y4zSMONO0vldsoMD8Fb7UZyuoDwuWxNRV4I5vFydRPWQLn");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("FKNnYY");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("nPk");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("LjQg0TXgZY0WEpvCfYfoMc2lP6urKmTEXvoGb9chAmv7TcOOtl");
            communicationgroup.setCommGroupName("ocgcx03bCWmzQmSdLlEe6IYAi73DDlHhJYxsM3JUecAqjvRJ5C");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("G18TVm8ShpBxI8oHazG92D5vFPRBXAYVbykrHQHvErGaUWW8jW");
            communicationtype.setCommTypeName("2IRKkUD9eOxOxPdiZ9LYoqic4Uy8PCphQL78vDBiMWeyE6rqwL");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("vVv");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(76);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("p0uPatsSya5egnpRFvWG5ZeRvJ8c1HTgUpdp41FhlyQzaSg5Yz");
            corecontacts.setFirstName("GcEZ7ytnAD2EVrlZzi6iXJvIw4HoLnH2q7yI88YampEMfY3qYe");
            corecontacts.setLastName("9loZviewjKEJAG3pWh5fBr8bdZFA6Optdrhd0t77sP8VCHO6VC");
            corecontacts.setMiddleName("QcU4IKda50mNn9LoVMN9oNI1ohRFAPh3aFMQr4EgmvcCmdBnSF");
            corecontacts.setNativeFirstName("htLLPq4awvXEqa030wCP9Kl3DR2yDlF1vcNjBMv35LNz8DvFqH");
            corecontacts.setNativeLastName("1RIBYr4QhmzFNMWRSg2w8wTp5PDTx0hEQs2fvwKzqlxsGht4CO");
            corecontacts.setNativeMiddleName("F9rCMr6GV20N1zd797Ha3YQVLhjf7KY3Wd4nHXSlOZZ08FjK7S");
            corecontacts.setNativeTitle("h2FsZ061Mo4rV3O4auGavmXZHRPwZaTbW1pljdG0dvrsrMNTsI");
            corecontacts.setPhoneNumber("UyGFn3IFteN5DvWXYLBw");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
