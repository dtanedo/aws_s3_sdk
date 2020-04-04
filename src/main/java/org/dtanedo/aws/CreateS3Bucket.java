package org.dtanedo.aws;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.Region;

import java.io.IOException;

public class CreateS3Bucket {

    public static void main(String[] args) throws IOException {
        AmazonS3ClientBuilder amazonS3ClientBuilder = AmazonS3ClientBuilder.standard();
        amazonS3ClientBuilder.setCredentials(new ProfileCredentialsProvider());
        amazonS3ClientBuilder.setRegion(Region.AP_Singapore.getFirstRegionId());
        AmazonS3 s3Client = amazonS3ClientBuilder.build();

        String bucketName = "";
        if (s3Client.doesBucketExistV2(bucketName)) {
            s3Client.createBucket(new CreateBucketRequest(bucketName));
        }


    }

}
