import numpy as np
from numpy import linalg
import time
##create very large random square array

x=np.random.rand(20000,20000)

#invert matrix
start = time.time()
linalg.inv(x)
end = time.time()
print(end - start)
#took about 5 min with this size array
