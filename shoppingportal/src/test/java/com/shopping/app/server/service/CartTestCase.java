package com.shopping.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shopping.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.shopping.app.server.repository.CartRepository;
import com.shopping.app.shared.onlineshopping.Cart;
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
import com.shopping.app.shared.onlineshopping.Item;
import com.shopping.app.server.repository.ItemRepository;
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
public class CartTestCase {

    @Autowired
    private CartRepository<Cart> cartRepository;

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
            Item item = new Item();
            item.setItemIcon("TMk");
            item.setItemName("0uOYDG6JawEcIolTaqXnlJYxpmHZFfRsTIRfL4f2UnSsNfet5Q");
            item.setItemPrice(12.34);
            item.setItemStock(2147483647);
            Item ItemTest = itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("prolJvAg8bnI9I7mV3DoeTXLtlpVvw2k9TdvuTe8YKboc1qppr");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(672);
            user.setUserAccessCode(4);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("mYHwaDvJm2tXfyQadqeFSznt5ZWDUahXylpj1GMt9wgDQVckwr");
            useraccessdomain.setDomainHelp("QvwbptgN2SFyDNRNKpYyJ0tng6riTBJ4g50YnNuvMlZpnaeM3j");
            useraccessdomain.setDomainIcon("dsngnrnMxReVFrHYgdQrJs8qE50EcLPfS3cHBA8yEATDq1RntR");
            useraccessdomain.setDomainName("ZFTH8sVJmxGtz4YTe2XrlAN06tErxmygcxB6pm04vwcij7dEIi");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("ZhyeHKYg6cgkP8a7lysNJ06VBa75QqYdjUSzWcpiBmObJQ4DZ2");
            useraccesslevel.setLevelHelp("kRebvtUwRfgyO44O11U4HgtXmCy7Dgm30NXemb0PKGMZT8ayBW");
            useraccesslevel.setLevelIcon("MLZcv4Bshd5E3WqtZdEzW407pJJV2N8e0C1q6KH7SW8umCJcqP");
            useraccesslevel.setLevelName("FAWV6X5EoG3LvdA7ruv4FeEcimBOpwoGRb9a41VxHNs9rUsqHh");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("7deRSrFO9z91GTR2l22yWKw58YEinhcLnr2X5I2gJTflh8UtFk");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(104);
            user.setUserAccessCode(5);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            Cart cart = new Cart();
            cart.setItemId((java.lang.String) ItemTest._getPrimarykey()); /* ******Adding refrenced table data */
            cart.setItemName("buNJ51DbzRwo8bJ7u0nwfYeSKJjk4XDbFocnJeIFwPCWX1WtIk");
            cart.setItemPrice(12.34);
            cart.setItemQuantity(2147483647);
            cart.setSubTotal(12.34);
            cart.setUserId((java.lang.String) UserTest._getPrimarykey());
            cart.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            cart.setEntityValidator(entityValidator);
            cart.isValid();
            cartRepository.save(cart);
            map.put("CartPrimaryKey", cart._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ItemRepository<Item> itemRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            Cart cart = cartRepository.findById((java.lang.String) map.get("CartPrimaryKey"));
            cart.setItemName("RqEVQUojitBQhohcFCzC5BihEMvrC3xqHEIG8rgRkZ6YLetpqY");
            cart.setItemPrice(12.34);
            cart.setItemQuantity(2147483647);
            cart.setSubTotal(12.34);
            cart.setVersionId(1);
            cart.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cartRepository.update(cart);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            cartRepository.findById((java.lang.String) map.get("CartPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByitemId() {
        try {
            java.util.List<Cart> listofitemId = cartRepository.findByItemId((java.lang.String) map.get("ItemPrimaryKey"));
            if (listofitemId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<Cart> listofuserId = cartRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            cartRepository.delete((java.lang.String) map.get("CartPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            itemRepository.delete((java.lang.String) map.get("ItemPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
