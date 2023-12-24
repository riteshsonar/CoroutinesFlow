package com.example.coroutinesexamples.KoltinTutorial



/* class and Functions
* public: This is the default modifier in Kotlin. It makes the element accessible from anywhere.
private: Limits the visibility to the same file or enclosing scope.
protected: Makes the element visible in subclasses.
internal: Makes the element visible within the same module.
* */
fun main(){

}

class A{
    public var p= 10
    private var q= 10
    internal var r= 10
    protected  var s= 10
}


/*
Visbility Modifires

        modifires           Top Level Declarations                  Class Member
        Public                  EveryWhere                              EveryWhere
        inernal                 With in a module                        with in a module
        private                 with in file                            with in class
        protected                  N/A                                  Subclasses */
