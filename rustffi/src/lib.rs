use std::fmt::{Display, Formatter};

mod ffi;

#[repr(C)]
#[derive(Debug)]
pub struct City{
    x:f32,
    y:f32,
    z:f32,
}

impl City {
    fn getX(&self) -> f32 {
        self.x
    }
    fn getY(&self) -> f32 {
        self.y
    }
    fn getZ(&self) -> f32 {
        self.z
    }
    pub fn new(x: f32, y: f32, z: f32) -> City {
        City{x, y, z}
    }
}

#[repr(C)]
pub struct Entity(f32, f32, f32);

impl Entity {
    fn getAoiX(&self) -> f32 {
        self.1
    }
    fn getAoiY(&self) -> f32 {
        self.0
    }
    fn getAoiRange(&self) -> f32 {
        self.2
    }
    pub fn new(x: f32, y: f32, range: f32) -> Entity {
        Entity(x, y, range)
    }
}

impl Display for Entity {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        write!(f,"x:{},y:{},r:{}",self.0,self.1,self.2)
    }
}