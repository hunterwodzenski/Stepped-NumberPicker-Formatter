# Stepped-NumberPicker-Formatter
Create a stepped Android Studio NumberPicker with a NumberPicker Formatter

        //Example number picker where the time is stepped by 1, 5 and 15 minutes over 8 hours
        
        //Stepped Number Picker
        final NumberPicker stNp = findViewById(R.id.stNp);
        
        //1 minute
        stNp.setMinValue(1);
        
        //8 hours or 480 minutes
        stNp.setMaxValue(96);
        
        //increment stNP number picker by 1, 5 and 15 minutes
        NumberPicker.Formatter stNpFormatter = new NumberPicker.Formatter() {
        
            @Override
            //i is the number picker index
            public String format(int i) {
                int min = i % 60;
                int hr = i / 60;
                
                //after 60 minutes with step index
                if(i>60) {
                    //5*12=60
                    min = (i%12)*5;
                    hr = (i/12) - 4;
                }
                
                //after 120 minutes with step index
                if(i>72) {
                    //4*15=60
                    min = (i%4)*15;
                    hr = (i/4) - 16;
                }
                
                //return formatted time
                return String.format(Locale.getDefault(), "%d:%02d", hr, min);
            }
        };
