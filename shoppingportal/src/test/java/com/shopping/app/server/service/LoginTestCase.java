package com.shopping.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shopping.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shopping.app.server.repository.LoginRepository;
import com.shopping.app.shared.authentication.Login;
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
import com.shopping.app.shared.contacts.CoreContacts;
import com.shopping.app.server.repository.CoreContactsRepository;
import com.shopping.app.shared.contacts.Gender;
import com.shopping.app.server.repository.GenderRepository;
import com.shopping.app.shared.location.Language;
import com.shopping.app.server.repository.LanguageRepository;
import com.shopping.app.shared.location.Timezone;
import com.shopping.app.server.repository.TimezoneRepository;
import com.shopping.app.shared.contacts.Title;
import com.shopping.app.server.repository.TitleRepository;
import com.shopping.app.shared.authentication.User;
import com.shopping.app.server.repository.UserRepository;
import com.shopping.app.shared.authentication.UserAccessDomain;
import com.shopping.app.server.repository.UserAccessDomainRepository;
import com.shopping.app.shared.authentication.UserAccessLevel;
import com.shopping.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(32);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("Uqry4dFVq0tW0SkeTS0ah3fvA8KxbqnzTi9EtATMOyrZSwmJxU");
            corecontacts.setFirstName("IrSd662b383a7cqbhQ1drIuFHEFulxEDgZr7c1Yur0NxWJaCa0");
            Gender gender = new Gender();
            gender.setGender("iBxmF2rOq8WIl9MmGjSKYQi1esluIijrZEsA3blP0UuFwbueZe");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("zO");
            language.setAlpha3("vBZ");
            language.setAlpha4("kcF0");
            language.setAlpha4parentid(6);
            language.setLanguage("dlABkbSeM9dLb7bn72AURq8tKeF4nGOi4iWPUhWfFoUYfXzTQi");
            language.setLanguageDescription("Tu3Rm8tX0u0UzRv9v6LlVk5cWuTDLrTGNGYhAj2Go94on21jGx");
            language.setLanguageIcon("zDnECW2x6VZpSVHntGhwbYl1TYjKaII0d5hujCwhFRf0vy0LtS");
            language.setLanguageType("YBZq3taw9HaNjlqAb4CbA3tV9A4aQrNa");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("WO2LmHQ4u9TtnIpqf5u30Q8xZ3oBhb42S3Sl6wpNX1WbO6jmKB");
            timezone.setCountry("XU57XLtZaaYISwTlBHVvByoNWxTWS0DCB83xRStN8rzGlLPt6c");
            timezone.setGmtLabel("3cg0ZEfzRmXGxrpmQaiR99Tb1m68nU85W5ElcjvhN4r8irOTWj");
            timezone.setTimeZoneLabel("JMFMyXN7GOxmLOlaPdHsE3sm2mgVOKUZsdhll314rPDurOssMQ");
            timezone.setUtcdifference(7);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("YMSO402CBIKhH8ErLWL2CnY9p0z8XJbQpOU11TkBkGJ3IrakjI");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(48);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("hnhbtraTZU1WUqYTUjqifhi1EC5eYNjNCI82ymq2WpEKxljfRs");
            corecontacts.setFirstName("A9rOvLHSuDNj7wbmFohXYHsYoo6JTK61jHaLlpwWbD3MfPTiMp");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("bQeWab8WyGobW3fBc9YI6cFTLtBIUiCFlbU8Lz48nKALLI9wAo");
            corecontacts.setMiddleName("gn3UB4eYGPq7ui9ufeEoXjdCpVttwqEk3pS6e1xIFhtD0GumEb");
            corecontacts.setNativeFirstName("weinLdQRE7Cl3fek93Ordq6pNuUNPYfccL1sYLM487XSg6jNtb");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("c1wpd4NgnrXQD1lM4KiuLfLfITdiJs6siPey6jTJUqx9FPsS7u");
            corecontacts.setNativeMiddleName("r8QtIo0DMtGuKU1CHR4wtAwX1f4WmnICHEVxJS7RjJi2Zo0GeB");
            corecontacts.setNativeTitle("ZjopAK0fMBrfnJZjN3GxQlo3J3sGs8Hk5IL9rHKHrc0QcZD2Rz");
            corecontacts.setPhoneNumber("6zIZSiGutWIntgGK5EgR");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("vVcADIZJPC5z5Jy6n1gJhcx7UWjzuAH1Z30kB3hNVKWYZD3grH");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2451);
            user.setUserAccessCode(1);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("n9FRXIH8qXND9ffN0L56Kp8jGZlNUv3EbOrWs6ct3gkJCVesrK");
            useraccessdomain.setDomainHelp("oOntpDLC7YRXtUCaqrxipG6iWcm42LL7sbDOdKfSnp1v1os3uy");
            useraccessdomain.setDomainIcon("3z0Ot47l7tekT4I60I9rqN0JJc1JqS8sd1VYnvo9qAd4T65UXO");
            useraccessdomain.setDomainName("Xzgub8zoCLA4vq3KFN0MIBXm3O6nrrw0pADNWRmTuwHVktFKJX");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("QI0eVDzx6iaH9r8yJ0LFszKmnsjzYdR5LcuqjFJ8okj6Ft5ji5");
            useraccesslevel.setLevelHelp("BYKMcX6RM6VKU2bEwO0ZvuSlzTErodGrjXJ2Ga8QsWrfkiWXd4");
            useraccesslevel.setLevelIcon("DBuS6UvOsIhzfMsnQSu1zooYOaVVAEgHvwoPSF5BKCkzfzGVh0");
            useraccesslevel.setLevelName("YIng9MF9GBe3tk7Ru0SEvRTfmRIsX5xo1yC2beeWFoijaLwLwj");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("Q8EPuaquiGooW8ATw730mRFu8RUuRmUVjOsaDkp9v8wgPNF5P1");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1524);
            user.setUserAccessCode(2);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(9);
            login.setIsAuthenticated(true);
            login.setLoginId("N1oj72NyuIZLykOpJMyphegq7zsyIUVqxxKe2ylQWRKKGRNq1C");
            login.setServerAuthImage("G6q9dD65kscFQh3Q4eUFNE0qDWDtRDER");
            login.setServerAuthText("v0aUlyHm5js5TU6f");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(3);
            login.setLoginId("Iq6T9oS066MLf1k7K5sJaoXvDhacxDOaq6tEEHgUugBP2g01Dg");
            login.setServerAuthImage("XObPVS1KqNN9Sx2KoRL62hsC74wDQ5rg");
            login.setServerAuthText("54Qa0AcZPaXgUKe3");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
