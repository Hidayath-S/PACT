package se.ff.bsv.verifyer;
import org.junit.runners.model.TestClass;
import org.junit.runners.model.TestClass.*;

public interface NewTestClassAwareTarget extends NewTarget {
	void setTestClass(TestClass testClass, Object testTarget);

}
