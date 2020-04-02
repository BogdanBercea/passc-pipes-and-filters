package assemblers;

public class ChairPacker{
    private FurniturePipe mGetPipe;

    public void setPipe(FurniturePipe leftPipe) {
        mGetPipe = leftPipe;
    }


//    @Override
//    public void run() {
//        try{
//            this.build();
//        }catch (Exception e) {
//            e.printStackTrace();;
//        }
//    }

    public void build() {
        while(true) {
            if (mGetPipe.getUnassembledChair() == null) {
//            System.out.println("Packer: Waiting a chair to pack....");
                //wait
            }
            else {
                System.out.println("Packer: Packing new chair...");
                for (int i = 0; i < 100000; i++);
                mGetPipe.clearPipe();
                System.out.println("Packer: New chair packed");
//                mGetPipe = null;
            }
        }
    }
}
