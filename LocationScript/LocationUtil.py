import pandas as pd
import scipy as sp
import numpy as np
import matplotlib as plt
import math
from scipy.interpolate import interp1d


def is_ascending(x):
    temp = x.copy()
    temp.sort()
    # print(x, temp)
    if temp == x:
        return True
    else:
        return False


def turning(df):
    # plt.figure(0)
    rad_conv = 0.0174533
    theta = 45
    x_prime = df['X'].tolist()
    y_prime = df['Y'].tolist()
    # plt.plot(x_prime, y_prime)
    count = 0
    while is_ascending(x_prime) != True and count < 200:
        x_prime = []
        y_prime = []
        for row in df.itertuples(index = True, name = 'Pandas'):
            x_prime.append((getattr(row, "X") * np.cos(theta * rad_conv)) - getattr(row, "Y")*np.sin(theta * rad_conv))
            y_prime.append((getattr(row, "Y") * np.cos(theta * rad_conv)) + getattr(row, "X")*np.sin(theta * rad_conv))
        theta = theta + 45
        count += 1
        # print(count)
        # plt.plot(x_prime, y_prime)
        # print("X: ",x_prime,"Y: ", y_prime)
        if theta > 360:
            break
        # print(isAscending(x_prime))
    theta = theta - 45
    df_new = pd.DataFrame({'X' : x_prime, 'Y' : y_prime})    
    return df_new, theta


def turn_back(df, theta):
    rad_conv = 0.0174533
    new_theta = 360 - theta
    x_prime = df['X'].tolist()
    y_prime = df['Y'].tolist()
    x_prime = []
    y_prime = []
    for row in df.itertuples(index = True, name = 'Pandas'):
        x_prime.append((getattr(row, "X") * np.cos(new_theta * rad_conv)) - getattr(row, "Y")*np.sin(new_theta * rad_conv))
        y_prime.append((getattr(row, "Y") * np.cos(new_theta * rad_conv)) + getattr(row, "X")*np.sin(new_theta * rad_conv))
    df_new = pd.DataFrame({'X' : x_prime, 'Y' : y_prime})
    return df_new


# Distance between two points
def distance(xi, yi, xii, yii):
    sq1 = (xi - xii) ** 2
    sq2 = (yi - yii) ** 2
    return math.sqrt(sq1 + sq2)


# ========================EVENLY SPACE BY ARCLENGTH========================
def evenArcX(func, xmin, xmax, r):  # test = 3, testac = 0.1) :

    ## func - function of your curve, must output a "y" for given "x"
    ## xmin,xmax - the range of the function you want to operate on
    ## r - number of points you want to evenly distrubute

    outx = [];

    res = r

    badx = np.linspace(xmin, xmax, res)
    bady = func(badx)

    # get three test points
    # testlist = []
    # testlist.append(rn.randint(0,len(badx)))

    arcdist = []

    for i in range(1, len(badx)):
        # print("i:", i)
        # print("x:", round( badx[i-1], 2 ), "-" , round( badx[i], 2))
        arcdist.append(distance(badx[i - 1], bady[i - 1], badx[i], bady[i]))

    # print(len(arcdist))
    # print(arcdist)

    # for i in range(0, len(arcdist) - 1):
    #    newx.extend( np.linspace(badx[i], badx[i+1], math.floor(arcdist[i])) )

    indist = [1 / x for x in arcdist]
    indist.insert(0, 0)
    subx = np.cumsum(indist)
    outx = np.asarray([x * (xmax / subx[-1]) for x in subx])
    # print(outx)
    return outx


def euclid_to_geo(eXs, eYs, gStart, gEnd):

    ## eXs - List of X values to be converted to GeoLocations
    ## eYs - List of Y values to  e converted to GeoLocations
    ## gStart - List with 0 as Long, and 1 as Lat to be used to create factor
    ## gEnd - List with 0 as Long, and 1 as Lat to be used to create factor

    new_long = []
    new_lat = []
    rx_min = eXs[0]
    rx_max = eXs[-1]
    ry_min = eYs[0]
    ry_max = eYs[-1]
    tx_min = gStart[0]
    tx_max = gEnd[0]
    ty_min = gStart[-1]
    ty_max = gEnd[-1]
    for i in eXs:
        m = ((i - rx_min) / abs(rx_max - rx_min)) * (abs(tx_max - tx_min)) + tx_min
        new_long.append(m)
    for j in eYs:
        m = ((j - ry_min) / abs(ry_max - ry_min)) * (abs(ty_max - ty_min)) + ty_min
        new_lat.append(m)

    return new_long, new_lat




