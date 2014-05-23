package it.geosolutions.jaiext.scale;

import static org.junit.Assert.assertFalse;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This test-class extends the TestScale class and is used for testing the nearest interpolation inside the Scale operation.
 * The registration method is not written and is ignored. The 2nd method tests the scale operation without the presence of a
 * ROI or a No Data Range. The 3rd method introduces a ROI object calculated using a ROI RasterAccessor while the 4th method 
 * uses an Iterator on the ROI Object. The 5th method performs the scale operation with all the components. The last method 
 * is similar to the 5th method but executes its operations on binary images. 
 */
public class NearestScaleTest extends TestScale {
    
    
    
    @Test
    @Ignore
    public void testScaleRegistration() {
        // The registration test must be done
        assertFalse("This operation must be already registered", true);
    }

    @Test
    public void testImageScaling() {
        boolean roiPresent=false;
        boolean noDataRangeUsed=false;
        boolean isBinary=false;
        boolean bicubic2DIsabled= true;
        boolean useROIAccessor=false;
              
        testGlobal(useROIAccessor,isBinary,bicubic2DIsabled,noDataRangeUsed
                ,roiPresent,InterpolationType.NEAREST_INTERP, TestSelection.NO_ROI_ONLY_DATA,ScaleType.MAGNIFY);
        
        testGlobal(useROIAccessor,isBinary,bicubic2DIsabled,noDataRangeUsed
                ,roiPresent,InterpolationType.NEAREST_INTERP, TestSelection.NO_ROI_ONLY_DATA,ScaleType.REDUCTION);
    }

    @Test
    public void testImageScalingROIAccessor() {
        
        boolean roiPresent=true;
        boolean noDataRangeUsed=false;
        boolean isBinary=false;
        boolean bicubic2DIsabled= true;
        boolean useROIAccessor=true;
              
        testGlobal(useROIAccessor,isBinary,bicubic2DIsabled,noDataRangeUsed
                ,roiPresent,InterpolationType.NEAREST_INTERP,TestSelection.ROI_ACCESSOR_ONLY_DATA,ScaleType.MAGNIFY);
        
        testGlobal(useROIAccessor,isBinary,bicubic2DIsabled,noDataRangeUsed
                ,roiPresent,InterpolationType.NEAREST_INTERP,TestSelection.ROI_ACCESSOR_ONLY_DATA,ScaleType.REDUCTION);
    }

    @Test
    public void testImageScalingROIBounds() {
        
        boolean roiPresent=true;
        boolean noDataRangeUsed=false;
        boolean isBinary=false;
        boolean bicubic2DIsabled= true;
        boolean useROIAccessor=false;
              
        testGlobal(useROIAccessor,isBinary,bicubic2DIsabled,noDataRangeUsed
                ,roiPresent,InterpolationType.NEAREST_INTERP,TestSelection.ROI_ONLY_DATA,ScaleType.MAGNIFY);
        
        testGlobal(useROIAccessor,isBinary,bicubic2DIsabled,noDataRangeUsed
                ,roiPresent,InterpolationType.NEAREST_INTERP,TestSelection.ROI_ONLY_DATA,ScaleType.REDUCTION);
    }
    
    @Test
    public void testImageScalingTotal() {        
        
        boolean roiPresent=true;
        boolean noDataRangeUsed=true;
        boolean isBinary=false;
        boolean bicubic2DIsabled= true;
        boolean useROIAccessor=true;
              
        testGlobal(useROIAccessor,isBinary,bicubic2DIsabled,noDataRangeUsed
                ,roiPresent,InterpolationType.NEAREST_INTERP,TestSelection.ROI_ACCESSOR_NO_DATA,ScaleType.MAGNIFY);
        
        testGlobal(useROIAccessor,isBinary,bicubic2DIsabled,noDataRangeUsed
                ,roiPresent,InterpolationType.NEAREST_INTERP,TestSelection.ROI_ACCESSOR_NO_DATA,ScaleType.REDUCTION);
    }

    
    @Test
    public void testImageScalingBinary() {
        boolean roiPresent=true;
        boolean noDataRangeUsed=true;
        boolean isBinary=true;
        boolean bicubic2DIsabled= true;
        boolean useROIAccessor=true;
                      
        testGlobal(useROIAccessor,isBinary,bicubic2DIsabled,noDataRangeUsed
                ,roiPresent,InterpolationType.NEAREST_INTERP,TestSelection.BINARY_ROI_ACCESSOR_NO_DATA,ScaleType.MAGNIFY);
        
        testGlobal(useROIAccessor,isBinary,bicubic2DIsabled,noDataRangeUsed
                ,roiPresent,InterpolationType.NEAREST_INTERP,TestSelection.BINARY_ROI_ACCESSOR_NO_DATA,ScaleType.REDUCTION);
    }
}