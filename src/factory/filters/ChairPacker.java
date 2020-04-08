package factory.filters;

import factory.pipe.FurniturePipe;
import factory.pipelines.Pipeline;

/**
 * @author Luigi Bolovan
 *
 * Chair packer class.
 * Waits for chairs in order to pack them.
 */

public class ChairPacker {
    private FurniturePipe       mGetPipe;
    private final static int    PACKING_TIME = 1000;

    public void setPipe(FurniturePipe leftPipe) {
        mGetPipe = leftPipe;
    }

    public void pack() {
        while(true) {
            if (mGetPipe.getUnassembledChair() == null) {
                //wait for chairs in GET pipe
            }
            else {
                try{
                    Thread.sleep(PACKING_TIME);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }

                mGetPipe.clearPipe();
                System.out.println("Packer: New chair packed");
            }
        }
    }
}
