// #![crate_type = "cdylib"]
#![feature(slice_ptr_len)]
#![feature(slice_ptr_get)]
use std::borrow::BorrowMut;
use std::cell::RefCell;
use std::collections::hash_map::RandomState;
use std::collections::{HashMap, HashSet};
use std::ffi::{CStr, CString};
use std::mem;
use std::os::raw::{c_char, c_float, c_int};
use std::ptr::{slice_from_raw_parts, slice_from_raw_parts_mut};
use std::str;
use crate::{Entity, City};
use std::fmt::Write;

/// Convert a native string to a Rust string
fn to_string(pointer: *const c_char) -> String {
    let slice = unsafe { CStr::from_ptr(pointer).to_bytes() };
    str::from_utf8(slice).unwrap().to_string()
}

/// Convert a Rust string to a native string
fn to_ptr(string: String) -> *const c_char {
    let cs = CString::new(string.as_bytes()).unwrap();
    let ptr = cs.as_ptr();
    // Tell Rust not to clean up the string while we still have a pointer to it.
    // Otherwise, we'll get a segfault.
    mem::forget(cs);
    ptr
}


/// Example of passing and returning a value
/// The string argument and return types are native C strings (pointers to arrays of c_chars).
#[no_mangle]
#[allow(non_snake_case)]
pub extern "C" fn printString(name: *const c_char) -> *const c_char {
    let name = to_string(name);
    // Convert the Rust string back to a C string so that we can return it
    to_ptr(format!("Rust print: {}!", name))
}

#[no_mangle]
#[allow(non_snake_case)]
pub extern "C" fn printArray(clen: c_int, array: *const c_float) -> () {
    let slice = slice_from_raw_parts(array, clen as usize);
    let list = unsafe { &*slice };
    println!("rust {:?}", list);
    mem::forget(slice);
}

#[no_mangle]
#[allow(non_snake_case)]
pub extern "C" fn printArrayAndChange(clen: c_int, array: *mut c_float) -> () {
    let mut list = slice_from_raw_parts_mut::<f32>(array, clen as usize);
    unsafe {
        println!("rust {:?}", &*list);
        for i in 0..clen {
            let v = i as f32 + 10f32;
            (*list)[i as usize] = v;
        }
        println!("rust changed:{:?}", &*list);
    };
    mem::forget(list);
}


#[no_mangle]
#[allow(non_snake_case)]
pub extern "C" fn test_tuple(obj:*mut Entity) -> *const c_char {
    println!("Rust print: {}!", unsafe { obj.as_ref().unwrap()});
    let e=unsafe{
        obj.replace(Entity::new(10 as f32, 20 as f32, 30 as f32));
        &*obj
    };
    to_ptr(format!("Rust return: {}!", e))
}
