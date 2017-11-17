import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.StaticApplicationContext;

public class RuntimeInjectionTest
{
    private class TestClass
    {
        final int value;

        public TestClass(final int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    }

    @Test
    public void testInjection() throws Exception
    {
        final StaticApplicationContext context = new StaticApplicationContext();
        final ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        final TestClass testClass = new TestClass(8);
        beanFactory.registerSingleton(TestClass.class.getName(), testClass);

        Assert.assertTrue(((TestClass) context.getBean(TestClass.class.getName())).getValue() == 8);
    }
}
