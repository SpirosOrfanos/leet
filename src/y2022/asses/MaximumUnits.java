package y2022.asses;
//https://leetcode.com/problems/maximum-units-on-a-truck/

import java.util.*;

public class MaximumUnits {
    public static void main(String[] args) {
        MaximumUnits app = new MaximumUnits();
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<UnitType> unitTypes = new ArrayList();
        for (int[] i  : boxTypes)
            unitTypes.add(new UnitType(i[0], i[1]));
        Collections.sort(unitTypes);
        int units = 0;

        for (UnitType ut : unitTypes) {
            if (truckSize - ut.boxes >= 0) {
                truckSize-=ut.boxes;
                units+=(ut.boxes*ut.units);
            } else  {
                units+=(truckSize*ut.units);
                truckSize = 0;
            }

            if (truckSize <= 0) break;
        }
        return units;
    }
    private class UnitType implements Comparable<UnitType>{

        int boxes;
        int units;
        UnitType (int boxes, int units) {
            this.boxes = boxes;
            this.units = units;
        }

        @Override
        public int compareTo(UnitType o) {
            return this.units>o.units ? -1 : this.units == o.units ? 0 : 1;
        }
    }
}



