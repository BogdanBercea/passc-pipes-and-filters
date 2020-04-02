import assemblers.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BackrestChairPipeline implements Pipeline {
    private static final int NUMBER_OF_PIPES = 4;
    private SeatCutter mSeatCutter;
    private BackrestAssembler mBackrestAssembler;
    private FeetAssembler mFeetAssembler;
    private StabilizerAssembler mStabilizerAssembler;
    private ChairPacker mPacker;
    private ArrayList<FurniturePipe> furniturePipes = new ArrayList<FurniturePipe>();
    private Thread mBackrestJob;
    private Thread mFeetAssemblerJob;
    private Thread mStabilizerAssemblerJob;
    private Thread mPackerJob;

    public BackrestChairPipeline(){
        for(int i = 0; i < NUMBER_OF_PIPES; i++){
            furniturePipes.add(new FurniturePipe());
        }
        setPipelineOrder();
    }

    private void setPipelineOrder(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Enter the order of the pipeline: \n" +
                    "C - seat cutter\n" +
                    "B - backrest assembler\n" +
                    "F - feet assembler\n" +
                    "S - stabilizer assembler\n" +
                    "P - chair packer\n" +
                    "Constraints: \n" +
                    "\t - seat cutter must be first\n" +
                    "\t - packer is the last\n" +
                    "\t - stabilizer bar assembler is after feet assembler\n" +
                    "Example: CBFSP\n" +
                    "Order:");
            String order;
            order = reader.readLine();

            checkEnteredOrder(order);

            populateFilters();

            mSeatCutter.setPipe(furniturePipes.get(order.toLowerCase().indexOf('c')));
            System.out.println("Cutter will put chair in the" + furniturePipes.indexOf(furniturePipes.get(order.toLowerCase().indexOf('c'))) + "pipe");
            mBackrestAssembler.setLeftPipe(furniturePipes.get(order.toLowerCase().indexOf('b') - 1));
            System.out.println("Backrest assembler will get chair from the" + furniturePipes.indexOf(furniturePipes.get(order.toLowerCase().indexOf('b') - 1)) + "pipe");
            mBackrestAssembler.setRightPipe(furniturePipes.get(order.toLowerCase().indexOf('b')));
            System.out.println("Backrest assembler will put chair in the" + furniturePipes.indexOf(furniturePipes.get(order.toLowerCase().indexOf('b'))) + "pipe");
            mStabilizerAssembler.setLeftPipe(furniturePipes.get(order.toLowerCase().indexOf('s') - 1));
            System.out.println("Stabilizer assembler will get chair from the" + furniturePipes.indexOf(furniturePipes.get(order.toLowerCase().indexOf('s') - 1)) + "pipe");
            mStabilizerAssembler.setRightPipe(furniturePipes.get(order.toLowerCase().indexOf('s')));
            System.out.println("Stabilizer assembler will put chair in the" + furniturePipes.indexOf(furniturePipes.get(order.toLowerCase().indexOf('s'))) + "pipe");
            mFeetAssembler.setLeftPipe(furniturePipes.get(order.toLowerCase().indexOf('f') - 1));
            System.out.println("feet assembler will get chair from the" + furniturePipes.indexOf(furniturePipes.get(order.toLowerCase().indexOf('f') - 1)) + "pipe");
            mFeetAssembler.setRightPipe(furniturePipes.get(order.toLowerCase().indexOf('f')));
            System.out.println("feet assembler will put chair in the" + furniturePipes.indexOf(furniturePipes.get(order.toLowerCase().indexOf('f'))) + "pipe");
            mPacker.setPipe(furniturePipes.get(order.toLowerCase().indexOf('p') - 1));
            System.out.println("packer assembler will get chair from the" + furniturePipes.indexOf(furniturePipes.get(order.toLowerCase().indexOf('p') - 1)) + "pipe");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkEnteredOrder(String order) {
        if(order.toLowerCase().charAt(0) != 'c'){
            System.out.println("Seat cutter must be the first");
            System.exit(1);
        }
        if(order.toLowerCase().charAt(4) != 'p'){
            System.out.println("Packer must be the last in the pipeline order");
            System.exit(1);
        }
        if(order.toLowerCase().indexOf('f') > order.toLowerCase().indexOf('s')){
            System.out.println("Stabilizer bar assembler must be after feet assembler");
            System.exit(1);
        }
        if(order.length() != 5){
            System.out.println("Insert 5 letters only");
            System.exit(1);
        }
        if(     order.toLowerCase().indexOf('c') == -1 ||
                order.toLowerCase().indexOf('b') == -1 ||
                order.toLowerCase().indexOf('f') == -1 ||
                order.toLowerCase().indexOf('s') == -1 ||
                order.toLowerCase().indexOf('p') == -1      ){

            System.out.println("One or more elements from pipeline are missing");
            System.exit(1);
        }
    }

    private void populateFilters(){
        mSeatCutter = new SeatCutter();
        mBackrestAssembler = new BackrestAssembler();
        mFeetAssembler = new FeetAssembler();
        mPacker = new ChairPacker();
        mStabilizerAssembler = new StabilizerAssembler();
    }

    @Override
    public void assembleChair(ChairInProgress chair) {
        mSeatCutter.build(chair);
    }

    @Override
    public void putAssemblersToWork(){
//        Thread seatCutter = new Thread(() -> mSeatCutter.build());
        mBackrestJob = new Thread(() -> mBackrestAssembler.build());

        mFeetAssemblerJob = new Thread(() -> mFeetAssembler.build());

        mStabilizerAssemblerJob = new Thread(() -> mStabilizerAssembler.build());

        mPackerJob = new Thread(() -> mPacker.build());

//        seatCutter.start();
        mBackrestJob.start();
        mFeetAssemblerJob.start();
        mStabilizerAssemblerJob.start();
        mPackerJob.start();
    }

    @Override
    public boolean isReady() {
        if(mSeatCutter.isReady()) return true;
        return false;

    }

    @Override
    public void stop() {
        //joining threads
        try {
            mBackrestJob.join();
            mFeetAssemblerJob.join();
            mPackerJob.join();
            mStabilizerAssemblerJob.join();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
