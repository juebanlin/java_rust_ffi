package net.jueb.rust.ffi;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class City extends Struct {
        public float x;
        public float y;
        public float z;

        public City(Runtime runtime) {
            super(runtime);
        }
    }