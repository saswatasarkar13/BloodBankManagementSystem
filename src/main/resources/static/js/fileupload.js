const uploadFileToFirebaseBucket = async (file, filename) => {
  try {
    const res = await storageRef.child(filename).put(file);
    const furl = await res.ref.getDownloadURL();
    return furl;
  } catch (err) {
    console.log(err);
    return null;
  }
};
