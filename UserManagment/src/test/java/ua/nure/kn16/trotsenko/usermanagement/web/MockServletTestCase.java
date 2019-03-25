package ua.nure.kn16.trotsenko.usermanagement.web;

import com.mockobjects.dynamic.Mock;
import com.mockrunner.servlet.BasicServletTestCaseAdapter;
import ua.nure.kn16.trotsenko.usermanagement.db.DaoFactory;
import ua.nure.kn16.trotsenko.usermanagement.db.MockDaoFactory;

import java.util.Properties;

public abstract class MockServletTestCase extends BasicServletTestCaseAdapter {

    private Mock mockUserDao;

    public Mock getMockUserDao() {
        return mockUserDao;
    }

    public void setMockUserDao(Mock mockUserDao) {
        this.mockUserDao = mockUserDao;
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Properties properties = new Properties();
        properties.setProperty("dao.factory", MockDaoFactory.class.getName());
        DaoFactory.init(properties);
        setMockUserDao(((MockDaoFactory)DaoFactory.getInstance()).getMockUserDao());
    }

    @Override
    public void tearDown() throws Exception {
        getMockUserDao().verify();
        super.tearDown();
    }

}
