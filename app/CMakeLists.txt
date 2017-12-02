
cmake_minimum_required(VERSION 3.4.1)



add_library( # Sets the name of the library.
             Hello

             # Sets the library as a shared library.
             SHARED

             src/main/cpp/Hello.c )


add_library( # Sets the name of the library.
             CCallJava

             # Sets the library as a shared library.
             SHARED

             src/main/cpp/CCallJava.c )


target_link_libraries( # Specifies the target library.
                       Hello

                       ${log-lib} )

target_link_libraries( # Specifies the target library.
                       CCallJava

                       ${log-lib} )

find_library( # Sets the name of the path variable.
              log-lib

              log )