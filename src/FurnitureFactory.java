import assemblers.ChairInProgress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FurnitureFactory {
    private Pipeline mPipeline;

    public FurnitureFactory(Pipeline pipeline){
        mPipeline = pipeline;
    }

    public void receiveOrders(){
        int noOfChairs = getNoOfChairs();
        int i          = 0;
        if(noOfChairs > 0){
            mPipeline.putAssemblersToWork();
            System.out.println("Chairs: " + noOfChairs);
            while(i < noOfChairs){
                if(mPipeline.isReady()) {
                    mPipeline.assembleChair(new ChairInProgress());
                    i++;
                }
            }
            mPipeline.stop();
        }

    }

    private int getNoOfChairs() {
        int noOfChairs = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of chairs:");
        try{
            noOfChairs = Integer.parseInt(reader.readLine());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        return noOfChairs;
    }
}
