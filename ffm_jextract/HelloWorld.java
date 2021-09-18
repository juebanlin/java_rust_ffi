/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import static org.hello.helloworld_h.*;
import static org.hello.student.*;
import jdk.incubator.foreign.*;

public class HelloWorld {
    public static void main(String[] args) {
        test();
        int i=0;
        long time=System.currentTimeMillis();
        for(;;){
            test();
            i++;
            if(System.currentTimeMillis()-time>2){
                break;
            }
        }
        System.out.println("i:"+i);
    }

    static void test(){
        helloworld();
        try (ResourceScope scope=ResourceScope.newConfinedScope()){
            MemorySegment segment= allocate(scope);
            age$set(segment,20);
            height$set(segment,170);
            MemorySegment name=CLinker.toCString("java student",scope);
            name$set(segment,name.address());
            printstruct(segment.address());

            MemorySegment returnstruct=getstruct(scope);
            MemoryAddress nameAddress=name$get(returnstruct);
            String r_name=CLinker.toJavaString(nameAddress);
            int r_age=age$get(returnstruct);
            double r_height=height$get(returnstruct);
            System.out.println("name:"+r_name+",age:"+r_age+",height:"+r_height);
        }
    }
}

