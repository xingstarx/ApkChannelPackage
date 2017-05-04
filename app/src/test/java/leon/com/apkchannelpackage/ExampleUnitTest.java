package leon.com.apkchannelpackage;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testFindFile() throws IOException {
        File file = new File("baseApk/v1-base-debug.apk");
        JarFile jarFile = new JarFile(file);
        JarEntry jarEntry = jarFile.getJarEntry("META-INF/MANIFEST.MF");

        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            if (entry.getName().endsWith(".SF")) {
                System.out.println("entry.getName() ==" + entry.getName() + ", entry == " + entry);
            }
        }
        System.out.println("file.exists() ==" + file.exists());
    }
}