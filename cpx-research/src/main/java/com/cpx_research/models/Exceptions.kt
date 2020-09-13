package com.cpx_research.models

import java.lang.Exception

class CPXNotInitializedException : Exception("CPXResearch is not initialized, make sure the init function is called.")