package utils;


import org.testng.*;
import setup.Base;

public class TestListener extends Base implements ITestListener,
        IExecutionListener, IInvokedMethodListener, IAnnotationTransformer {

    ScreenshotUtil scrn = new ScreenshotUtil() ;

    @Override
    public void onTestFailure(ITestResult result) {

        if (result.getName().contains("Trails")) {

            String methodName = result.getName().toString().trim();
            System.out.println(methodName);
            scrn.takeScreenShot(methodName, Base.driver);
        }

    }


}
