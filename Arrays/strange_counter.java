static long strangeCounter(long t) {
        long counter = 3;
        long val_cycle = 3;
        while(t>counter)
        {
            val_cycle*=2;
            counter+=val_cycle;
        }
        long st_point = counter - val_cycle +1;
        long diff = t-st_point;
        val_cycle = val_cycle-diff;
        return val_cycle;

    }
