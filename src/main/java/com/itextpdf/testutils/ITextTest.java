package com.itextpdf.testutils;

import javax.management.OperationsException;
import java.io.File;

public abstract class ITextTest {

    public void runTest() throws Exception {
        System.out.println("Starting test.");
        String outPdf = getOutPdf();
        if (outPdf == null || outPdf.length() == 0)
            throw new OperationsException("outPdf cannot be empty!");
        makePdf(outPdf);
        assertPdf(outPdf);
        comparePdf(outPdf, getCmpPdf());
        System.out.println("Test complete.");
    }

    protected abstract void makePdf(String outPdf) throws Exception;

    /**
     * Gets the name of the resultant PDF file.
     * This name will be passed to <code>makePdf</code>, <code>assertPdf</code> and <code>comparePdf</code> methods.
     * @return
     */
    protected abstract String getOutPdf();

    protected void assertPdf(String outPdf) throws Exception {

    }

    protected void comparePdf(String outPdf, String cmpPdf) throws Exception {

    }

    /**
     * Gets the name of the compare PDF file.
     * This name will be passed to <code>comparePdf</code> method.
     * @return
     */
    protected String getCmpPdf() {
        return "";
    }

    protected void deleteDirectory(File path) {
        if (path == null)
            return;
        if (path.exists()) {
            for (File f : path.listFiles()) {
                if (f.isDirectory()) {
                    deleteDirectory(f);
                    f.delete();
                } else {
                    f.delete();
                }
            }
            path.delete();
        }
    }

    protected void deleteFiles(File path) {
        if (path != null && path.exists()) {
            for (File f : path.listFiles()) {
                f.delete();
            }
        }
    }
}
